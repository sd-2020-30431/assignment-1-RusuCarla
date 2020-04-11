import { Component, OnInit } from '@angular/core';
import {GroceriesModel} from '../addgroceries/addgroceries.model';
import {HttpClient, HttpHeaders} from '@angular/common/http';
import {Router} from '@angular/router';
import {ConsumptionModel} from './consumption.model';

@Component({
  selector: 'app-menu',
  templateUrl: './menu.component.html',
  styleUrls: ['./menu.component.css']
})
export class MenuComponent implements OnInit {
  groceries: GroceriesModel[];
  consumptionModel: ConsumptionModel = new ConsumptionModel();
  field;
  username: string;
  constructor(private http: HttpClient, private router: Router) { }

  ngOnInit(): void {
    this.getGroceries();
  }

  getGroceries(){
    this.username = window.localStorage.getItem('username');
    const httpOptions = {
      headers: new HttpHeaders({
        userId: window.localStorage.getItem('userId')
      })
    };

    this.http.get<GroceriesModel[]>('http://localhost:8080/groceries/getGroceries',
      httpOptions).subscribe(result => {
        this.groceries = result;
        console.table(this.groceries);
      },
      error => console.log(error));
  }

  addConsumptionDate(){
    const httpOptions = {
      headers: new HttpHeaders({
        userId: window.localStorage.getItem('userId')
      })
    };

    this.field = (document.getElementById('field')) as HTMLSelectElement;
    this.consumptionModel.name = this.field.options[this.field.selectedIndex].text.toString();
    console.log(this.consumptionModel);
    this.http.post('http://localhost:8080/groceries/addConsumptionDate', this.consumptionModel, httpOptions).subscribe(
      result => {
        console.log(result);
        alert('Successfully added consumption date.');
      },
      error => {
        console.log(error);
      });
    setTimeout(() => {  this.getGroceries(); }, 2000);
  }

}
