import { Component, OnInit } from '@angular/core';
import { TrekkingService } from '../core/services/trekking.service';
import { Router } from '@angular/router';
import { BaseResponse } from '../trekking-req-resp/base-response';
import { Trekking } from '../trekking-req-resp/trekking-model';
import { TrekkingRequest } from '../trekking-req-resp/trekking-request';

@Component({
  selector: 'app-trekking-create',
  templateUrl: './trekking-create.component.html',
  styleUrls: ['./trekking-create.component.css']
})
export class TrekkingCreateComponent implements OnInit {

  trekking: Trekking = new Trekking();
  trekkingRequest: TrekkingRequest = new TrekkingRequest();
  response: BaseResponse;

  constructor(private trekkingService: TrekkingService,
    private router: Router) { }

  ngOnInit(): void {
  }

  createTrekkingData() {
    this.trekkingRequest.trekking = this.trekking
    this.trekkingService.createTrekkingData(this.trekkingRequest).subscribe(
      response => {
        this.response = response;
      },
      err => {

      }
    )
  }

  goBack(): void {
    this.router.navigateByUrl('/trekkings');
  }
}
