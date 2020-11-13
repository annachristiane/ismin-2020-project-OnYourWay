import { Prop, Schema, SchemaFactory } from '@nestjs/mongoose';
import { Document } from 'mongoose';

@Schema({collection: 'Lignes-App-ACK'})
export class LigneDocument extends Document {
  @Prop()
  status: string;

  @Prop()
  id_line: string;

  @Prop()
  transportsubmode: string;

  @Prop()
  transportmode: string;

  @Prop()
  shortname_line: string;

  @Prop()
  name_line: string;

  @Prop()
  shortname_groupoflines: string;

  @Prop()
  networkname: string;

  @Prop()
  operatorname: string;
}

export const LigneSchema = SchemaFactory.createForClass(LigneDocument);
