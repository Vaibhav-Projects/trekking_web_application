import { Component, OnInit } from '@angular/core';
import { TrekkingService } from '../core/services/trekking.service'
import { TrekkingResponse } from '../trekking-req-resp/trekking-response';
import { Trekking } from '../trekking-req-resp/trekking-model';

@Component({
  selector: 'app-trekking',
  templateUrl: './trekking.component.html',
  styleUrls: ['./trekking.component.css']
})
export class TrekkingComponent implements OnInit {

  trekkingResponse: TrekkingResponse;
  trekkings: Trekking[];
  message : string;

  constructor(private trekkingService: TrekkingService) { }

  ngOnInit(): void {
    this.getHeros();
  }

  getHeros() {
    this.trekkingService.getTrekkingDetails().subscribe(
      response => {
        if (response.responseCode == "200") {
          this.trekkingResponse = response;
          this.trekkings = this.trekkingResponse.trekkings;
        }

      },
      err => {
      
      }
    )
  }

}
