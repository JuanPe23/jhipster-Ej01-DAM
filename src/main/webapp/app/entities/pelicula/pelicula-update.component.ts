import { Component, OnInit } from '@angular/core';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { HttpResponse, HttpErrorResponse } from '@angular/common/http';
// eslint-disable-next-line @typescript-eslint/no-unused-vars
import { FormBuilder, Validators } from '@angular/forms';
import { ActivatedRoute } from '@angular/router';
import { Observable } from 'rxjs';
import { filter, map } from 'rxjs/operators';
import * as moment from 'moment';
import { DATE_TIME_FORMAT } from 'app/shared/constants/input.constants';
import { JhiAlertService } from 'ng-jhipster';
import { IPelicula, Pelicula } from 'app/shared/model/pelicula.model';
import { PeliculaService } from './pelicula.service';
import { IEstreno } from 'app/shared/model/estreno.model';
import { EstrenoService } from 'app/entities/estreno/estreno.service';

@Component({
  selector: 'jhi-pelicula-update',
  templateUrl: './pelicula-update.component.html'
})
export class PeliculaUpdateComponent implements OnInit {
  isSaving: boolean;

  estrenos: IEstreno[];

  editForm = this.fb.group({
    id: [],
    titulo: [null, [Validators.required, Validators.minLength(4), Validators.maxLength(50)]],
    fechaEstreno: [],
    descripcion: [null, [Validators.minLength(20), Validators.maxLength(500)]],
    enCines: []
  });

  constructor(
    protected jhiAlertService: JhiAlertService,
    protected peliculaService: PeliculaService,
    protected estrenoService: EstrenoService,
    protected activatedRoute: ActivatedRoute,
    private fb: FormBuilder
  ) {}

  ngOnInit() {
    this.isSaving = false;
    this.activatedRoute.data.subscribe(({ pelicula }) => {
      this.updateForm(pelicula);
    });
    this.estrenoService
      .query()
      .pipe(
        filter((mayBeOk: HttpResponse<IEstreno[]>) => mayBeOk.ok),
        map((response: HttpResponse<IEstreno[]>) => response.body)
      )
      .subscribe((res: IEstreno[]) => (this.estrenos = res), (res: HttpErrorResponse) => this.onError(res.message));
  }

  updateForm(pelicula: IPelicula) {
    this.editForm.patchValue({
      id: pelicula.id,
      titulo: pelicula.titulo,
      fechaEstreno: pelicula.fechaEstreno != null ? pelicula.fechaEstreno.format(DATE_TIME_FORMAT) : null,
      descripcion: pelicula.descripcion,
      enCines: pelicula.enCines
    });
  }

  previousState() {
    window.history.back();
  }

  save() {
    this.isSaving = true;
    const pelicula = this.createFromForm();
    if (pelicula.id !== undefined) {
      this.subscribeToSaveResponse(this.peliculaService.update(pelicula));
    } else {
      this.subscribeToSaveResponse(this.peliculaService.create(pelicula));
    }
  }

  private createFromForm(): IPelicula {
    return {
      ...new Pelicula(),
      id: this.editForm.get(['id']).value,
      titulo: this.editForm.get(['titulo']).value,
      fechaEstreno:
        this.editForm.get(['fechaEstreno']).value != null ? moment(this.editForm.get(['fechaEstreno']).value, DATE_TIME_FORMAT) : undefined,
      descripcion: this.editForm.get(['descripcion']).value,
      enCines: this.editForm.get(['enCines']).value
    };
  }

  protected subscribeToSaveResponse(result: Observable<HttpResponse<IPelicula>>) {
    result.subscribe(() => this.onSaveSuccess(), () => this.onSaveError());
  }

  protected onSaveSuccess() {
    this.isSaving = false;
    this.previousState();
  }

  protected onSaveError() {
    this.isSaving = false;
  }
  protected onError(errorMessage: string) {
    this.jhiAlertService.error(errorMessage, null, null);
  }

  trackEstrenoById(index: number, item: IEstreno) {
    return item.id;
  }
}
