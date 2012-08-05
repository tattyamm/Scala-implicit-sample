/**
 * implicitまわりがよくわからなかったのでサンプル作成。
 * 参考  コップ本
 *       http://twitter.github.com/scala_school/advanced-types.html
 *       http://d.hatena.ne.jp/unageanu/20080531/1212232674
 *       http://tech.cm55.com/wiki/scala/implicit
 *
 *
 */

object ImplicitSample {

  //暗黙の引数 (implicit parameters)
  def methodWithImplicitArg1(implicit s: String = "Sampple Text") {
    println("methodWithImplicitArg called:" + s)
  }

  def methodWithImplicitArg2(implicit a: Int, b: Long) {
    println("methodWithImplicitArg called:" + a * b)
  }

  def methodWithImplicitArg3(implicit s: SampleClass) {
    println("methodWithImplicitArg called:" + s)
  }
  implicit val toBeImplicitArg = new SampleClass(1);
  class SampleClass(value: Int) {
    override def toString = { "Sample:" + value }
  }

  //暗黙の型変換
  implicit def strToInt(x: String) = x.toInt

  def main(args: Array[String]) {

    //暗黙の引数 (implicit parameters)
    //  引数を省略する事が可能になる。
    methodWithImplicitArg1
    methodWithImplicitArg1()
    methodWithImplicitArg1("hoge")

    //  型で判断して暗黙的に供給してくれる
    implicit val intValue = 10
    implicit val longValue = 20L
    methodWithImplicitArg2
    methodWithImplicitArg2(3, 1L)

    //  valに限らず、関数でもオブジェクトでもかまわない
    methodWithImplicitArg3



    //暗黙の型変換 (implicit conversion)
    //  乱用すると、訳が分からなくなる。
    println(math.max("123", 111))

  }

}
