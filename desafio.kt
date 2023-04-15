    enum class Nivel {
        BASICO,
        INTERMEDIARIO,
        AVANCADO }

    data class Usuario(
        val nome: String)

    data class ConteudoEducacional(
        val nome: String,
        val duracao: Int,
        val nivel: Nivel)

    data class Formacao(
        val nome: String,
        val conteudos: List<ConteudoEducacional>,
        val nivel: Nivel) {

        val inscritos = mutableListOf<Usuario>()

        fun matricular(usuario: Usuario) {
            inscritos.add(usuario)
        }

        fun imprimirInscritos(){
            for (inscrito in inscritos) {
                println(inscrito.nome)
            }
        }

        fun imprimirConteudoFormacao(){
            for (conteudo in conteudos) {
                println("${conteudo.nome} - ${conteudo.duracao}")
            }
        }
    }

    fun main() {

        val curso1 = ConteudoEducacional("Docker", 20, Nivel.BASICO)
        val curso2 = ConteudoEducacional("Java", 80, Nivel.AVANCADO)
        val curso3 = ConteudoEducacional("Kotlin", 80, Nivel.AVANCADO)
        val curso4 = ConteudoEducacional("Framework Spring", 40, Nivel.INTERMEDIARIO)

        val listaConteudos = mutableListOf<ConteudoEducacional>()
        listaConteudos.add(curso1)
        listaConteudos.add(curso2)
        listaConteudos.add(curso3)

        val formacao1 = Formacao("Desenvolvedor Back end", listaConteudos, Nivel.AVANCADO)

        val usuario1 = Usuario("Steven Spielberg")
        val usuario2 = Usuario("Alfred Hitchcock")
        val usuario3 = Usuario("Charlie Chaplin")

        formacao1.matricular(usuario1)
        formacao1.matricular(usuario2)
        formacao1.matricular(usuario3)

        print("Formação: ")
        println("${formacao1.nome} - ${formacao1.nivel}")
        println("Cursos da formação: ")
        println(formacao1.imprimirConteudoFormacao())
        println()
        println("Lista de inscritos: ")
        println(formacao1.imprimirInscritos())
    }
