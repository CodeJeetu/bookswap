import { Component, OnInit } from '@angular/core';
import { RouterModule, RouterOutlet } from '@angular/router';
import { ApiCallService } from './services/api-call.service';

@Component({
  selector: 'app-root',
  standalone: true,
  imports: [RouterOutlet, RouterModule],
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {
  title = 'book-swap-test';

  constructor(private _api: ApiCallService) { }

  ngOnInit(): void {
    this.setupToggleButton();
  }

  setupToggleButton(): void {
    const toggleButton = document.querySelector('.navbar-toggler');
    const menu = document.getElementById('navbarNav');

    if (toggleButton && menu) {
      toggleButton.addEventListener('click', () => {
        menu.classList.toggle('show');
      });
    }
  }
}
