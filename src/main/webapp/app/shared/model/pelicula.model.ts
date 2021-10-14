import { Moment } from 'moment';
import { IEstreno } from 'app/shared/model/estreno.model';

export interface IPelicula {
  id?: number;
  titulo?: string;
  fechaEstreno?: Moment;
  descripcion?: string;
  enCines?: boolean;
  estreno?: IEstreno;
}

export class Pelicula implements IPelicula {
  constructor(
    public id?: number,
    public titulo?: string,
    public fechaEstreno?: Moment,
    public descripcion?: string,
    public enCines?: boolean,
    public estreno?: IEstreno
  ) {
    this.enCines = this.enCines || false;
  }
}
