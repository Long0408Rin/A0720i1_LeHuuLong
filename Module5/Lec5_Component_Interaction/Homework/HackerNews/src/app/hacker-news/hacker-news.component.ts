import { Component, OnInit } from '@angular/core';
import {IModels} from '../hacker-news-model/IModels';

@Component({
  selector: 'app-hacker-news',
  templateUrl: './hacker-news.component.html',
  styleUrls: ['./hacker-news.component.scss']
})
export class HackerNewsComponent implements OnInit {
  hackerNewsShow: string;
  message: string;
  articles: IModels[] = [
    {
      id: 1,
      title: 'The Evolution of Async JavaScript: From Callbacks, to Promises, to Async/Await',
      url: 'https://medium.freecodecamp.org/the-evolution-of-async-javascript-from-callbacks-to-promises-to-async-await-e73b047f2f40',
      likes: 10
    },
    {
      id: 2,
      title: 'Game of Life',
      url: 'https://thefullsnack.com/posts/game-of-life.html',
      likes: 4
    },
    {
      id: 3,
      title: 'Nguyên tắc thiết kế REST API',
      url: 'https://medium.com/eway/nguyên-tắc-thiết-kế-rest-api-23add16968d7',
      likes: 3
    },
    {
      id: 4,
      title: 'Why You Only Need to Test with 5 Users',
      url: 'https://www.nngroup.com/articles/why-you-only-need-to-test-with-5-users/',
      likes: 6
    },
    {
      id: 5,
      title: 'Let’s Build A Web Server. Part 1.',
      url: 'https://ruslanspivak.com/lsbaws-part1/',
      likes: 7
    }
  ];

  constructor() { }

  ngOnInit(): void {
  }

}
