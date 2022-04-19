import { IImage } from 'app/shared/model/image.model';

export interface ICategory {
  id?: number;
  name?: string;
  description?: string | null;
  images?: IImage[] | null;
}

export const defaultValue: Readonly<ICategory> = {};
