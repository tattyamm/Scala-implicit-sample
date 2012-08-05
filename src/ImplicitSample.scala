/**
 * implicitまわりがよくわからなかったのでサンプル作成。
 * 参考  コップ本
 * http://twitter.github.com/scala_school/advanced-types.html
 * http://d.hatena.ne.jp/unageanu/20080531/1212232674
 * http://tech.cm55.com/wiki/scala/implicit
 */

object ImplicitSample {

  def main(args: Array[String]) {

    //暗黙の引数 (implicit parameters)
    methodWithImplicitArg1
    methodWithImplicitArg1("hoge")

    //型で判断して暗黙的に供給してくれる
    //  valに限らず、関数でもオブジェクトでもかまわない
    implicit val intValue = 10
    implicit val longValue = 20L
    methodWithImplicitArg2
    methodWithImplicitArg2(3, 1L)

    //暗黙の型変換
    println(math.max("123", 111))

  }

  //暗黙の引数 (implicit parameters)
  def methodWithImplicitArg1(implicit s: String = "Sampple Text") {
    println("methodWithImplicitArg called:" + s)
  }

  def methodWithImplicitArg2(implicit a: Int, b: Long) {
    println("methodWithImplicitArg called:" + a * b)
  }

  //暗黙の型変換
  implicit def strToInt(x: String) = x.toInt

}
