import { Controller, Get, Post, Body, Param, Delete } from '@nestjs/common';
import { LigneService } from './ligne.service';
import { CreateLigneDto } from './create-ligne-dto';
import { LigneSchema,LigneDocument } from './ligne.schema';
import { hits, Ligne, record } from './Ligne';

@Controller('/lignes')
export class LigneController {
constructor(private readonly ligneService: LigneService) {}

 /* @Get()
  findAll(): Ligne[] {

  }*/

  @Post()
  async create(@Body() hits: hits): Promise<void> {
    return await this.ligneService.create(hits);
  }

  @Get(':id_line')
  async findByName(@Param('id_line') id_line) : Promise<Ligne> {
    return this.ligneService.findById(id_line);
  }

  @Get()
  async findByTransportMode(@Param('transportmode') transportmode): Promise<Ligne[]> {
    if(transportmode){
      return this.ligneService.findByTransportMode(transportmode);
    }
    else
      return this.ligneService.findAll();
  }

  @Delete(':id_line')
  async delete(@Param('id_line') id_line) : Promise<void> {
    return this.ligneService.delete(id_line);
  }
}
