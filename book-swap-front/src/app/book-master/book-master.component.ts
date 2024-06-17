import { Component } from '@angular/core';
import { NgModel } from '@angular/forms';
import { RouterModule, RouterOutlet, Routes } from '@angular/router';
import { routes } from '../app.routes';

@Component({
  selector: 'app-book-master',
  standalone: true,
  imports: [RouterModule,RouterOutlet],
  templateUrl: './book-master.component.html',
  styleUrl: './book-master.component.css'
})

export class BookMasterComponent {
  

  handleClick(id: string): void {
    const subLinks = document.getElementById(id);
    if (subLinks) {
      const allSubLinks = document.querySelectorAll('.sub-links');
      allSubLinks.forEach(link => {
        if (link.id !== id) {
          link.classList.remove('active');
        }
      });
      subLinks.classList.toggle('active');
    }
  }
}
