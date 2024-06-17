import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { ApiCallService } from '../services/api-call.service';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';

@Component({
  selector: 'app-user-login',
  standalone: true,
  imports: [RouterModule,CommonModule,FormsModule],
  templateUrl: './user-login.component.html',
  styleUrl: './user-login.component.css'
})
export class UserLoginComponent implements OnInit{
  userCredential:any
  Credential:any={
    userId:'',
    userPassword:''
  }

  constructor(private _route:ActivatedRoute , private _api:ApiCallService ){}
  ngOnInit() : void{

  }
  login(){
    this._api.userlogin(this.Credential).subscribe({
      next:data=>{
        this.userCredential=data;
        console.log(this.userCredential);
      },
      error:(error)=>{
        console.log(error);
      }
    })  

  }

}
