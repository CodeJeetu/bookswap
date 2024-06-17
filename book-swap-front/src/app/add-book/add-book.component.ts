import { Component, OnInit } from '@angular/core';
import { ApiCallService } from '../services/api-call.service';
import { FormsModule, NgModel } from '@angular/forms';
import { computeMsgId } from '@angular/compiler';
import { CommonModule } from '@angular/common';
import { RouterModule } from '@angular/router';

interface Book {
  bookName: string;
  authorName: string;
  publisher: string;
  publicationDate: string;
  edition: string;
  numberOfPages: number;
  bookFormat: string;
  dimensions: string;
  weight: number;
  language: string;
  bookCondition: string;
  description: string;
  tableOfContents: string;
  image1: string;
  image2: string;
  sellerName: string;
  makerDate: string;
  postedDate: string;
  recStatus: string;
}

@Component({
  selector: 'app-add-book',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterModule],
  templateUrl: './add-book.component.html',
  styleUrl: './add-book.component.css'
})
export class AddBookComponent implements OnInit {

  
  constructor(private _api:ApiCallService){}
  BookEntity: Book = { 
    bookName: '',
    authorName: '',
    publisher: '',
    publicationDate: '',
    edition: '',
    numberOfPages: 0,
    bookFormat: '',
    dimensions: '',
    weight: 0,
    language: '',
    bookCondition: '',
    description: '',
    tableOfContents: '',
    image1: '',
    image2: '',
    sellerName: '',
    makerDate: '',
    postedDate: '',
    recStatus: ''
  };

  ngOnInit() : void{
    
      }
      addBooks(){
      this._api.addBook(this.BookEntity).subscribe({
        next:data=>{
          console.log('Book added successfully', data);
          alert('Book added successfully');
        },
        error:(error)=>{
          console.log('Not Saved ');
        }
      })  

  }
}
