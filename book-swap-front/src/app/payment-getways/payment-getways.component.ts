import { Component, NgModule, OnInit } from '@angular/core';
import { ActivatedRoute, RouterModule } from '@angular/router';
import { ApiCallService } from '../services/api-call.service';
import { NgComponentOutlet } from '@angular/common';

@Component({
  selector: 'app-payment-getways',
  standalone: true,
  imports: [RouterModule,],
  templateUrl: './payment-getways.component.html',
  styleUrls: ['./payment-getways.component.css'] // Note the plural 'styleUrls' for consistency
})
export class PaymentGetwaysComponent implements OnInit {

  constructor(private _routes: ActivatedRoute, private _api: ApiCallService) {}

  ngOnInit(): void {
    this.changePayMethod(); 
  }

  changePayMethod(): void {
    document.getElementById('upi')?.addEventListener('change', function(this: HTMLInputElement) {
        if (this.checked) {
            document.getElementById('card-payment-form')?.classList.add('d-none');
            document.getElementById('upi-payment-form')?.classList.remove('d-none');
        }
    });

    document.getElementById('card')?.addEventListener('change', function(this: HTMLInputElement) {
        if (this.checked) {
            document.getElementById('upi-payment-form')?.classList.add('d-none');
            document.getElementById('card-payment-form')?.classList.remove('d-none');
        }
    });
  }
  hideElement(elementId: string): void {
    const element = document.getElementById(elementId);
    if (element) {
      element.classList.add('d-none');
    }
  }
   startWaitingForPayment():void {
    this.hideElement('pay-btn');
    this.hideElement('upi-payment-form');
    this.hideElement('card-payment-form');
    this.hideElement('payment-method');

    document.getElementById('payment-forms')?.classList.add('d-none');
    document.getElementById('payment-waiting')?.classList.remove('d-none');
   
    this.startCountdown();
}
startCountdown(): void {
  const countdownElement = document.getElementById('countdown');
  const progressBar = document.getElementById('progress-bar');
  const doneAnimation = document.getElementById('done-animation');
  const progressContainer = document.getElementById('progress-container');
  const countdownTimer = document.getElementById('countdown-timer');
  const waitingLabel = document.getElementById('waiting-label');
  let timeLeft = 10; // 10 seconds for testing
  const totalTime = timeLeft;

  const timerId = setInterval(() => {
    if (timeLeft <= 0) {
      clearInterval(timerId);
      if (countdownElement) countdownElement.innerText = '00:00';
      if (progressBar) progressBar.style.width = '100%';
      if (doneAnimation) doneAnimation.style.display = 'flex'; // Show the done animation
      if (progressContainer) progressContainer.style.display = 'none'; // Hide the progress bar container
      if (countdownTimer) countdownTimer.style.display = 'none'; // Hide the countdown timer
      if (waitingLabel) waitingLabel.innerText = 'Successfully Done'; 
    } else {
      const minutes = Math.floor(timeLeft / 60);
      const seconds = timeLeft % 60;
      if (countdownElement) countdownElement.innerText = `${this.pad(minutes)}:${this.pad(seconds)}`;
      const progress = ((totalTime - timeLeft) / totalTime) * 100;
      if (progressBar) progressBar.style.width = `${progress}%`;
      timeLeft--;
    }
  }, 1000);
}

pad(num: number): string {
  return num < 10 ? '0' + num : num.toString();
}
}
