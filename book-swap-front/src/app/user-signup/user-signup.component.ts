import { ApplicationModule, Component, NgModule, OnInit } from '@angular/core';
import { ActivatedRoute, Router, RouterModule } from '@angular/router';
import { ApiCallService } from '../services/api-call.service';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';


@Component({
  selector: 'app-user-signup',
  standalone: true,
  imports: [CommonModule,FormsModule,RouterModule],
  templateUrl: './user-signup.component.html',
  styleUrl: './user-signup.component.css'
})
export class UserSignupComponent implements OnInit {
  userInfo:any
  userData: any = { 
    firstName:   '',
    lastName:   '',
    dateOfBirth:   '',
    phoneNumber:   '',
    emailAddress:   '',
    landmark:   '',
    city:   '',
    state:   '',
    pincode:   '',
    recStatus:   'A'
  }
   constructNames(fullName: string): string[] {
    const names: string[] = fullName.split(" ");
    return names;
  }
  constructor(private router:Router,private _route:ActivatedRoute , private _api:ApiCallService ){
    
  }
  ngOnInit() : void{
  }
  saveUser() {
    
    const names: string[] = this.constructNames(this.userData.firstName);
    this.userData.firstName = names[0];
    this.userData.lastName = names[1];
    
    this._api.registerUser(this.userData).subscribe({
      next: (data) => {
        this.userInfo = data;
        console.log(this.userInfo); 
        alert("Sucessfuly Registerd");
        this.router.navigateByUrl('/login');
      },
      error: (error) => {
        console.log(error);
      }
    }); 
}
}

