//package com.example.demo.controller;
//
//import com.example.demo.entity.Discount;
//import com.example.demo.services.DiscountService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.domain.Pageable;
//import org.springframework.data.web.PageableDefault;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.validation.BindingResult;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import java.util.List;
//import java.util.Optional;
//
//
//    @Controller
//    @RequestMapping({"", "/product"})
//    public class DiscountController {
//        @Autowired
//        private DiscountService discountService;
//
//        @GetMapping
//        public String home(Model model, @PageableDefault(size = 5) Pageable pageable,
//                           @RequestParam Optional<String> keyword,
//                           @RequestParam Optional<String> keywordTwo,
//                           @RequestParam Optional<String> keywordAll,
//                           @RequestParam Optional<String> sortBy) {
//            loadList(model, pageable, keyword, keywordTwo, keywordAll, sortBy);
//            model.addAttribute("product", new Discount());
//            return "discount-home";
//        }
//
//        @PostMapping("/deleteDiscount")
//        public String deleteProduct(@RequestParam Integer deleteId, RedirectAttributes redirectAttributes) {
//            this.discountService.deleteDiscount(deleteTitle);
//            redirectAttributes.addFlashAttribute("message", "Delete Discount Complete !");
//            return "redirect:/discount-home";
//        }
//
//        @PostMapping("/createNew")
//        public String createNewProduct(RedirectAttributes redirectAttributes,
//                                       @Validated @ModelAttribute Discount discount, BindingResult bindingResult,
//                                       @PageableDefault(size = 5) Pageable pageable, Model model,
//                                       @RequestParam Optional<String> keyword, @RequestParam Optional<String> keywordTwo,
//                                       @RequestParam Optional<String> keywordAll,
//                                       @RequestParam Optional<String> sortBy) {
//            boolean check = false;
//            List<Discount> discountList = this.discountService.findAll();
//            for (Discount element : discountList) {
//                if (element.getId().equals(discount.getId())) {
//                    check = true;
//                    break;
//                }
//            }
//
//            if (bindingResult.hasFieldErrors() || check) {
//                loadList(model, pageable, keyword, keywordTwo, keywordAll, sortBy);
//                model.addAttribute("wrongCreate", "errorCreate");
//                if (!bindingResult.hasFieldErrors()) {
//                    model.addAttribute("idExist", "idExist");
//                    model.addAttribute("messageIdExist", "ID is exist ! Please input ID other !");
//                }
//                return "product-home";
//            }
//
//            this.discountService.save(discount);
//            redirectAttributes.addFlashAttribute("message", "Create Complete !");
//            return "redirect:/product";
//        }
//
//        private void loadList(Model model, @PageableDefault(size = 5) Pageable pageable,
//                              @RequestParam Optional<String> keyword, @RequestParam Optional<String> keywordTwo,
//                              @RequestParam Optional<String> keywordAll,
//                              @RequestParam Optional<String> sortBy) {
//            testInformation(model, pageable, keyword, keywordTwo, keywordAll, sortBy);
//            model.addAttribute("productTypeList", this.discountService.allProductType());
//        }
//
//        private void testInformation(Model model, @PageableDefault(size = 5) Pageable pageable,
//                                     @RequestParam Optional<String> keyword, @RequestParam Optional<String> keywordTwo,
//                                     @RequestParam Optional<String> keywordAll,
//                                     @RequestParam Optional<String> sortBy) {
//            String keywordOld = "";
//            String keywordTwoOld = "";
//            String keywordAllOld = "";
//            String informationSort = "";
//            if (keyword.isPresent() && !keyword.get().equals("")
//                    && keywordTwo.get().equals("") && keywordAll.get().equals("")) {
//                keywordOld = keyword.get();
//                model.addAttribute("productList",
//                        this.productService.findByNameContaining(pageable, keywordOld));
//            } else if (keywordTwo.isPresent() && !keywordTwo.get().equals("")
//                    && keyword.get().equals("") && keywordAll.get().equals("")) {
//                keywordTwoOld = keywordTwo.get();
//                model.addAttribute("productList",
//                        this.productService.findByPriceContaining(pageable, keywordTwoOld));
//            } else if (keyword.isPresent() && !keyword.get().equals("")
//                    && !keywordTwo.get().equals("") && keywordAll.get().equals("")) {
//                keywordOld = keyword.get();
//                keywordTwoOld = keywordTwo.get();
//                model.addAttribute("productList",
//                        this.productService.findByNameAndAddressContaining(pageable, keywordOld, keywordTwoOld));
//            }
//            else if (keywordAll.isPresent() && !keywordAll.get().equals("")
//                    && keywordTwo.get().equals("") && keyword.get().equals("")) {
//                keywordAllOld = keywordAll.get();
//                List<ProductType> productTypeList = this.productService.allProductType();
//                for (ProductType productType : productTypeList) {
//                    if (productType.getName().contains(keywordAllOld)) {
//                        keywordAllOld = productType.getId().toString();
//                        break;
//                    }
//                }
//                model.addAttribute("productList",
//                        this.productService.findByProductTypeContaining(pageable, keywordAllOld));
//            }
//            else if (keywordAll.isPresent() && !keywordAll.get().equals("")
//                    && !keywordTwo.get().equals("") && !keyword.get().equals("")) {
//                keywordAllOld = keywordAll.get();
//                keywordOld = keyword.get();
//                keywordTwoOld = keywordTwo.get();
//                List<ProductType> productTypeList = this.productService.allProductType();
//                for (ProductType productType : productTypeList) {
//                    if (productType.getName().contains(keywordAllOld)) {
//                        keywordAllOld = productType.getId().toString();
//                        break;
//                    }
//                }
//                model.addAttribute("productList",
//                        this.productService.findByAllContaining(pageable, keywordAllOld, keywordOld, keywordTwoOld));
//            }
//            else if (sortBy.isPresent() && !sortBy.get().equals("")) {
//                informationSort = sortBy.get();
//                if (informationSort.equals("id")) {
//                    model.addAttribute("productList", this.productService.findAllAndSortByID(pageable));
//                }
//                if (informationSort.equals("name")) {
//                    model.addAttribute("productList",
//                            this.productService.findAllAndSortByName(pageable));
//                }
//                if (informationSort.equals("birthDay")) {
//                    model.addAttribute("productList",
//                            this.productService.findAllAndSortByBirthDay(pageable));
//                }
//            } else {
//                model.addAttribute("productList", this.productService.findAll(pageable));
//            }
//            model.addAttribute("keywordOld", keywordOld);
//            model.addAttribute("keywordTwoOld", keywordTwoOld);
//            model.addAttribute("keywordAllOld", keywordAllOld);
//            model.addAttribute("informationSort", informationSort);
//        }
//
//        // Not Modal
//
//        @GetMapping("/showCreateNewForPage")
//        public String showCreateNewForPage(Model model) {
//            model.addAttribute("product", new Product());
//            model.addAttribute("productTypeList", this.productService.allProductType());
//            return "create-new-product";
//        }
//
//        @PostMapping("/createNewForPage")
//        public String createNewProduct(RedirectAttributes redirectAttributes,
//                                       @Validated @ModelAttribute Product product, BindingResult bindingResult,
//                                       Model model) {
//            boolean check = false;
//            List<Product> productList = this.productService.findAll();
//            for (Product element : productList) {
//                if (element.getId().equals(product.getId())) {
//                    check = true;
//                    break;
//                }
//            }
//
//            if (bindingResult.hasFieldErrors() || check) {
//                if (!bindingResult.hasFieldErrors()) {
//                    model.addAttribute("idExist", "idExist");
//                    model.addAttribute("messageIdExist", "ID is exist ! Please input ID other !");
//                }
//                model.addAttribute("productTypeList", this.productService.allProductType());
//                return "create-new-product";
//            }
//
//            this.productService.save(product);
//            redirectAttributes.addFlashAttribute("message", "Create Complete !");
//            return "redirect:/product";
//        }
//    }
//
//}
