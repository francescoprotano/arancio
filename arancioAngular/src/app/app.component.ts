import { Component } from '@angular/core';
import { AfterViewInit } from '@angular/core';
import { Router } from '@angular/router';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit {

  title = 'GestionePresenze';
  constructor(private router: Router) {}
  
  ngAfterViewInit() {
    setTimeout(() => {
       this.router.navigate(["/dipLogin"]);
    }, 2000);
   }
}

