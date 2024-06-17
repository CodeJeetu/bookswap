import { Component, OnInit } from '@angular/core';
import { ApiCallService } from '../services/api-call.service';
import { ActivatedRoute, Route } from '@angular/router';
import { routes } from '../app.routes';

@Component({
  selector: 'app-book-info',
  standalone: true,
  imports: [],
  templateUrl: './book-info.component.html',
  styleUrl: './book-info.component.css'
})
export class BookInfoComponent implements OnInit{
  bookInfo: any;
  bookRequest: any = { 
    bookId: ''
 };
  constructor(private _routes:ActivatedRoute , private _api:ApiCallService ){}
  ngOnInit() : void{
    this._routes.params.subscribe(params=>{
      this.bookRequest.bookId = params['id'];
    })

    this.getbookInfo();
  }
  getbookInfo(){
    this._api.getBookdetails(this.bookRequest).subscribe({
      next:data=>{
        this.bookInfo=data;
        console.log(this.bookInfo);
      },
      error:(error)=>{
        console.log(error);
      }
    })  
  }
}

