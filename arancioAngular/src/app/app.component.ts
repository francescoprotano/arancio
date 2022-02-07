import { Component } from '@angular/core';
import { AfterViewInit } from '@angular/core';
import { Router } from '@angular/router';
import { LoginService } from './services/login.service';
@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit {

  title = 'GestionePresenze';
  constructor(private router: Router, public authService : LoginService) {}
  
  ngAfterViewInit() {
    
       this.router.navigate(["/dipLogin"]);
   
   }
}

