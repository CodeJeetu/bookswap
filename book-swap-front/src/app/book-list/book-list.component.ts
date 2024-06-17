import { Component, OnInit } from '@angular/core';
import { RouterModule } from '@angular/router';
import { ApiCallService } from '../services/api-call.service';

@Component({
  selector: 'app-book-list',
  standalone: true,
  imports: [RouterModule],
  templateUrl: './book-list.component.html',
  styleUrl: './book-list.component.css'
})
export class BookListComponent implements OnInit{

  constructor(private _api:ApiCallService){}
  bookList:any;

  ngOnInit() : void{
    this.getBoOkList();
      }
  getBoOkList(){
      this._api.getbookList().subscribe({
        next:data=>{
          this.bookList=data;
          // console.log(this.bookList);
        },
        error:(error)=>{
          console.log(error);
        }
      })  

  }

}
