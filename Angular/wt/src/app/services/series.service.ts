import { Injectable } from '@angular/core';
import { Observable, throwError } from 'rxjs';
import { catchError, retry } from 'rxjs/operators';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SeriesService {

  constructor(private http: HttpClient) { }

  url = new URL("http://localhost:8080/JavaScript/resources/");

  username: string;

  login(username : string, password : string)
  {
    this.username = username;
    return this.http.post(this.url + 'users/' + this.username + '/login', { password: password }, { observe: 'response' });
  }

  addOrModifySeries(seriesData: ISeriesData)
  {
    return this.http.post(this.url + 'series/add?username=' + this.username, seriesData, { observe: 'response'});
  }
}

export interface ISeriesData
{
  title: string;
  numberOfSeasons: number;
  genre: string;
  streamingProvider: string;
  Score: number;
  Remark: string;
}
