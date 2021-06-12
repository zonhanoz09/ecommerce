import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent  {
  title = 'ecommerce-m';

  toggle: boolean = false;
  clickEventToggle(){
      this.toggle = !this.toggle;       
  }
}


