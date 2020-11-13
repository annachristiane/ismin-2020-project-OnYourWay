import { Document } from 'mongoose';

export interface Ligne extends Document {
  readonly status: string,
  readonly id_line: string,
  readonly transportsubmode: string,
  readonly transportmode: string,
  readonly shortname_line: string,
  readonly name_line: string,
  readonly shortname_groupoflines: string,
  readonly networkname: string,
  readonly operatorname: string
}
