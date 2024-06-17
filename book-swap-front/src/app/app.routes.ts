import { Routes } from '@angular/router';
import { BookInfoComponent } from './book-info/book-info.component';
import { HomeScreenComponent } from './home-screen/home-screen.component';
import { BookListComponent } from './book-list/book-list.component';
import { OrderPageComponent } from './order-page/order-page.component';
import { UserSignupComponent } from './user-signup/user-signup.component';
import { CartItemsComponent } from './cart-items/cart-items.component';
import { UserLoginComponent } from './user-login/user-login.component';
import { PaymentGetwaysComponent } from './payment-getways/payment-getways.component';
import { BookMasterComponent } from './book-master/book-master.component';
import { AddBookComponent } from './add-book/add-book.component';

export const routes: Routes = [
    {

        path:'',
        component: HomeScreenComponent,
        title:'Home'
        
    },
    {
        path:'book-info/:id',
        component: BookInfoComponent,
        title:'BookInfo'
    },
    {
        path:'all-books',
        component:BookListComponent,
        title:'all-books'
    },
    {
        path:'order-book/:id',
        component:OrderPageComponent,
        title:'Book-Order'
    },
    {
        path:'login',
        component:BookMasterComponent,      
        title:'User-Auth'
    },
    {
        path:'signup',
        component:UserSignupComponent,
        title:'sign-in'
    },
    {
        path:'cart-items',
        component:CartItemsComponent,
        title:'Cart View'
    },
    {
        path:'pay',
        component:PaymentGetwaysComponent,
        title:'transify'
    },
    {
        path: 'master',
        component: BookMasterComponent,
        children: [
          { path: 'add-book', component: AddBookComponent }
        //   { path: 'child2', component: ChildComponent2 },
        ]
      }
];
