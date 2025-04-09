import { IsUUID, IsDate, IsBoolean, IsOptional } from 'class-validator';
import { Type } from 'class-transformer';

export class CreateBorrowRecordDto {
  @IsUUID()
  readerId: string;

  @IsUUID()
  bookCopyId: string;

  @Type(() => Date)
  @IsDate()
  borrowDate: Date;

  @Type(() => Date)
  @IsDate()
  dueDate: Date;
}

export class UpdateBorrowRecordDto {
  @Type(() => Date)
  @IsDate()
  @IsOptional()
  returnDate?: Date;

  @IsBoolean()
  @IsOptional()
  isReturned?: boolean;
} 