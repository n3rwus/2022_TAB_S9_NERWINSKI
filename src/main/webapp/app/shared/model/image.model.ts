import dayjs from 'dayjs';
import { IUser } from 'app/shared/model/user.model';
import { IFolder } from 'app/shared/model/folder.model';
import { ICategory } from 'app/shared/model/category.model';

export interface IImage {
  id?: number;
  name?: string;
  imageContentType?: string;
  image?: string;
  description?: string | null;
  imageSize?: string;
  format?: string;
  dateOfCreate?: string;
  user?: IUser | null;
  folders?: IFolder[] | null;
  categories?: ICategory[] | null;
}

export const defaultValue: Readonly<IImage> = {};
