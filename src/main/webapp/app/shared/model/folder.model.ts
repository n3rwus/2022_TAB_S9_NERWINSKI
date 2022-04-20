import { IUser } from 'app/shared/model/user.model';
import { IImage } from 'app/shared/model/image.model';

export interface IFolder {
  id?: number;
  name?: string;
  description?: string | null;
  folder?: IFolder | null;
  user?: IUser | null;
  images?: IImage[] | null;
  parentFolders?: IFolder[] | null;
}

export const defaultValue: Readonly<IFolder> = {};
