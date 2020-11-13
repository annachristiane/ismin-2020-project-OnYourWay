
import { LigneController } from './ligne.controller';
import { LigneService } from './ligne.service';
import { Module } from '@nestjs/common';

@Module({
  imports: [ ],
  controllers: [LigneController],
  providers: [LigneService],
})
export class LigneModule {}
