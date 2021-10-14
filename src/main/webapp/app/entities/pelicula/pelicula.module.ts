import { NgModule } from '@angular/core';
import { RouterModule } from '@angular/router';

import { MiproyectoSharedModule } from 'app/shared/shared.module';
import { PeliculaComponent } from './pelicula.component';
import { PeliculaDetailComponent } from './pelicula-detail.component';
import { PeliculaUpdateComponent } from './pelicula-update.component';
import { PeliculaDeletePopupComponent, PeliculaDeleteDialogComponent } from './pelicula-delete-dialog.component';
import { peliculaRoute, peliculaPopupRoute } from './pelicula.route';

const ENTITY_STATES = [...peliculaRoute, ...peliculaPopupRoute];

@NgModule({
  imports: [MiproyectoSharedModule, RouterModule.forChild(ENTITY_STATES)],
  declarations: [
    PeliculaComponent,
    PeliculaDetailComponent,
    PeliculaUpdateComponent,
    PeliculaDeleteDialogComponent,
    PeliculaDeletePopupComponent
  ],
  entryComponents: [PeliculaDeleteDialogComponent]
})
export class MiproyectoPeliculaModule {}
