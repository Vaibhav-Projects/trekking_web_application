import { Trekking } from './trekking-model';
import { BaseResponse } from './base-response';

export class TrekkingResponse extends BaseResponse {

    trekkings: Trekking[];
}