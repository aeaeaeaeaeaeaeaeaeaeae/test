import { Entity, PrimaryGeneratedColumn, Column, ManyToOne, CreateDateColumn, UpdateDateColumn } from 'typeorm';
import { Reader } from './reader.entity';
import { BookCopy } from './book-copy.entity';

@Entity('borrow_records')
export class BorrowRecord {
  @PrimaryGeneratedColumn('uuid')
  id: string;

  @ManyToOne(() => Reader, reader => reader.borrowRecords)
  reader: Reader;

  @ManyToOne(() => BookCopy, bookCopy => bookCopy.borrowRecords)
  bookCopy: BookCopy;

  @Column()
  borrowDate: Date;

  @Column()
  dueDate: Date;

  @Column({ nullable: true })
  returnDate: Date;

  @Column({ default: false })
  isReturned: boolean;

  @CreateDateColumn()
  createdAt: Date;

  @UpdateDateColumn()
  updatedAt: Date;
} 