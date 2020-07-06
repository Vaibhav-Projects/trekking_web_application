import { Component, OnInit } from '@angular/core';
import { TrekkingService } from '../core/services/trekking.service';
import { TrekkingResponse } from '../trekking-req-resp/trekking-response';
import { Trekking } from '../trekking-req-resp/trekking-model';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.css']
})
export class DashboardComponent implements OnInit {

  trekkingResponse: TrekkingResponse;
  trekkings: Trekking[];

  constructor(private trekkingService: TrekkingService) { }

  ngOnInit(): void {
    this.getTrekkingDetails();
  }

  getTrekkingDetails() {
    this.trekkingService.getTrekkingDetails().subscribe(
      response => {
        this.trekkingResponse = response;
        this.trekkings = this.trekkingResponse.trekkings.slice(1,5);
      },
      err => {

      }
    );
  }
}
