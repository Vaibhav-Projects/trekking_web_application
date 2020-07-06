import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { TrekkingService } from '../core/services/trekking.service';
import { Trekking } from '../trekking-req-resp/trekking-model';
import { TrekkingResponse } from '../trekking-req-resp/trekking-response';
import { BaseResponse } from '../trekking-req-resp/base-response';
import { TrekkingRequest } from '../trekking-req-resp/trekking-request';

@Component({
  selector: 'app-trekking-detail',
  templateUrl: './trekking-detail.component.html',
  styleUrls: ['./trekking-detail.component.css']
})
export class TrekkingDetailComponent implements OnInit {

  trekkingResponse: TrekkingResponse;
  trekkingRequest: TrekkingRequest = new TrekkingRequest();
  baseRespone: BaseResponse;
  trekking: Trekking = new Trekking();
  message: string;

  constructor(private route: ActivatedRoute,
    private trekkingService: TrekkingService,
    private router: Router) { }

  ngOnInit(): void {
    this.getTrekkingDetailById();
  }

  getTrekkingDetailById(): void {
    const id = this.route.snapshot.paramMap.get('id');
    this.trekkingService.getTrekkingDetailsById(id).subscribe(
      response => {
        this.trekkingResponse = response;
        this.trekking = this.trekkingResponse.trekkings[0];
      },
      err => {

      }
    )
  }
  1
  updateTrekkingData() {
    this.trekkingRequest.trekking = this.trekking;
    this.trekkingService.updateTrekkingData(this.trekkingRequest).subscribe(
      response => {
        if (response.responseCode == "200") {
          this.baseRespone = response;
          this.message = response.responseMessage;
        }
      },
      err => {
        this.message = err;
      }
    );
    window.confirm(this.message);
  }

  deleteTrekkingData() {
    this.trekkingService.deleteTrekkingData(this.trekking.trekId).subscribe(
      response => {
        if (response.responseCode == "200") {
          this.baseRespone = response;
          this.message = response.responseMessage;
        }
      },
      err => {
          this.message = err;
      }
    );
    window.confirm(this.message);
  }

  goBack(): void {
    this.router.navigateByUrl('/dashboard');
  }

}
