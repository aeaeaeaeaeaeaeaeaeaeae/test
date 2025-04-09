import { Entity, PrimaryGeneratedColumn, Column, ManyToOne, OneToMany, CreateDateColumn, UpdateDateColumn } from 'typeorm';
import { Book } from './book.entity';
import { BorrowRecord } from './borrow-record.entity';

@Entity('book_copies')
export class BookCopy {
  @PrimaryGeneratedColumn('uuid')
  id: string;

  @Column()
  inventoryNumber: string;

  @Column({ default: true })
  isAvailable: boolean;

  @ManyToOne(() => Book, book => book.copies)
  book: Book;

  @OneToMany(() => BorrowRecord, borrowRecord => borrowRecord.bookCopy)
  borrowRecords: BorrowRecord[];

  @CreateDateColumn()
  createdAt: Date;

  @UpdateDateColumn()
  updatedAt: Date;
} 