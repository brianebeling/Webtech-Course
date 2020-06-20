import { Component, OnInit } from '@angular/core';
import { SeriesService } from 'src/app/services/series.service';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  userName:string;
  userPassword:string;
  public show:boolean = true;

  constructor(private seriesService : SeriesService) { }

  ngOnInit(): void {
  }

  
  SignIn()
  {
    this.seriesService.login(this.userName, this.userPassword);
    this.show=false;
  }
}
