import { IsBoolean, IsNotEmpty, IsString } from 'class-validator';
import { Ligne } from './Ligne';

export class CreateLigneDto implements Ligne{
  @IsNotEmpty()
  @IsString()
  date: string;

  @IsNotEmpty()
  @IsString()
  id_line: string;

  @IsNotEmpty()
  @IsString()
  name_line: string;

  @IsNotEmpty()
  @IsString()
  networkname: string;

  @IsNotEmpty()
  @IsString()
  operatorname: string;

  @IsNotEmpty()
  @IsString()
  shortname_groupoflines: string;

  @IsNotEmpty()
  @IsString()
  shortname_line: string;

  @IsNotEmpty()
  @IsString()
  status: string;

  @IsNotEmpty()
  @IsString()
  transportmode: string;

  @IsNotEmpty()
  @IsString()
  transportsubmode: string;

  @IsNotEmpty()
  @IsString()
  accessibility: string;

  @IsNotEmpty()
  @IsBoolean()
  favorite: boolean;
}

