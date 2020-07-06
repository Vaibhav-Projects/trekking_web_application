import { Injectable } from '@angular/core';
import { MessageService } from '../../messages/message.service';
import { environment } from 'src/environments/environment';
import { Trekking } from '../../trekking-req-resp/trekking-model';
import { HttpClient } from '@angular/common/http';
import { map } from 'rxjs/operators';
import { TrekkingResponse } from '../../trekking-req-resp/trekking-response';
import { BaseResponse } from '../../trekking-req-resp/base-response';
import { Observable } from 'rxjs';
import { TrekkingRequest } from 'src/app/trekking-req-resp/trekking-request';

@Injectable({
  providedIn: 'root'
})
export class TrekkingService {

  constructor(private messageService: MessageService,
    private httpClient: HttpClient) { }

  baseUrl: string = environment.baseUrl;

  getTrekkingDetails(): Observable<TrekkingResponse> {
    this.messageService.add("Trekking Service : Fetched Trekking Details");
    return this.httpClient.get(this.baseUrl + "?all=true").pipe(map(response => <TrekkingResponse>response));
  }

  getTrekkingDetailsById(id: string): Observable<TrekkingResponse> {
    this.messageService.add("Trekking Service : Fetched Trekking Detail of " + id);
    return this.httpClient.get(this.baseUrl + "?id=" + id).pipe(map(response => <TrekkingResponse>response));
  }

  createTrekkingData(trekkingRequest: TrekkingRequest): Observable<BaseResponse> {
    this.messageService.add("Trekking Service : Creating New Trekking Data");
    return this.httpClient.post(this.baseUrl, trekkingRequest).pipe(map(response => <BaseResponse>response));
  }

  updateTrekkingData(trekkingRequest: TrekkingRequest): Observable<BaseResponse> {
    this.messageService.add("Trekking Service : Updating Trekking Detail of " + trekkingRequest.trekking.trekId);
    return this.httpClient.put(this.baseUrl, trekkingRequest).pipe(map(response => <BaseResponse>response));
  }

  deleteTrekkingData(id: string): Observable<BaseResponse> {
    this.messageService.add("Trekking Service : Deleting Trekking Data of " + id);
    return this.httpClient.delete(this.baseUrl + "?id=" + id).pipe(map(response => <BaseResponse>response));
  }

}