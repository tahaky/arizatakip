import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {MainScreeenComponent} from "./core/views/main/main-screeen/main-screeen.component";
import {RouterModule, Routes} from "@angular/router";
import {HeaderComponent} from "./core/views/main/header/header.component";
import {NotFoundComponent} from "./core/views/not-found/not-found.component";
import {FaultComponent} from "./core/views/fault/fault.component";

const routes: Routes = [
    {path: 'main', component: MainScreeenComponent},
    {path: 'fault', component: FaultComponent},
    {path: '404', component: NotFoundComponent},
    {path: '**', redirectTo: '404'}
];

@NgModule({
    declarations: [],
    imports: [
        CommonModule,
        RouterModule.forRoot(routes)
    ],
    exports: [RouterModule],
})
export class AppRoutingModule {
}

