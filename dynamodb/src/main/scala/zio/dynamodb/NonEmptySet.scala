package zio.dynamodb

final class NonEmptySet[A] private (private val set: Set[A]) extends Iterable[A] {
  self =>
  def +(a: A): NonEmptySet[A]               = new NonEmptySet(set + a)
  def ++(that: Iterable[A]): NonEmptySet[A] = new NonEmptySet(set ++ that)

  override def iterator: Iterator[A] = set.iterator

}
object NonEmptySet {
  def apply[A](head: A, tail: Set[A]): NonEmptySet[A] = new NonEmptySet[A](tail + head)
  def apply[A](head: A, tail: A*): NonEmptySet[A]     = apply(head, tail.toSet)
}
