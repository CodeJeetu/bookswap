import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterLink, RouterModule, RouterOutlet } from '@angular/router';
import { ApiCallService } from '../services/api-call.service';

@Component({
  selector: 'app-order-page',
  standalone: true,
  imports: [RouterModule,RouterLink],
  templateUrl: './order-page.component.html',
  styleUrl: './order-page.component.css'
})
export class OrderPageComponent implements OnInit {
  
 

   OrderDetailsList: any;
   orderRequest: any = { 
    bookId: '',
     userId :'Jite'
  };
   constructor(private _routes:ActivatedRoute , private _api:ApiCallService ){}
   ngOnInit() : void{
     this._routes.params.subscribe(params=>{
       this.orderRequest.bookId = params['id'];
     })
     
     console.log("Here Object Is "+this.orderRequest.userId);
     console.log("Here Object Is "+this.orderRequest.bookId);
     this.fetchOrderDetails();
    }

  fetchOrderDetails()
  {
    this._api.fetchOrderList(this.orderRequest).subscribe({
      next:data=>{
        this.OrderDetailsList=data;
        console.log(this.OrderDetailsList);
      },
      error:(error)=>{
        console.log(error);
      }
    }) 
  }
}
  



