import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { TrekkingComponent } from './trekking/trekking.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { TrekkingDetailComponent } from './trekking-detail/trekking-detail.component';
import { TrekkingCreateComponent } from './trekking-create/trekking-create.component';


const routes: Routes = [
  { path: '', redirectTo: 'dashboard', pathMatch: 'full' },
  { path: 'trekkings', component: TrekkingComponent },
  { path: 'dashboard', component: DashboardComponent },
  { path: 'detail/:id', component: TrekkingDetailComponent },
  { path: 'create', component: TrekkingCreateComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
