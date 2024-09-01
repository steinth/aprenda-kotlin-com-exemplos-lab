enum class Nivel { BASICO, INTERMEDIARIO, AVANCADO }

class Usuario(val nome: String, val cpf: Long){
}

data class ConteudoEducacional(var nome: String, val duracao: Int = 60)

data class Formacao(val nome: String, var conteudos: List<ConteudoEducacional>, val nivel: Nivel) {

    val inscritos = mutableListOf<Usuario>()
    
    fun matricular(usuario: Usuario) {
        inscritos.add(usuario)
        println("${usuario.nome}, portador do CPF ${usuario.cpf}, foi matriculado no curso $nome.")
    }
}

fun main() {
    val usuario1 = Usuario("Thiago", 51822601929)
    val usuario2 = Usuario("Andre", 39600481707)
    
    val conteudo1 = ConteudoEducacional("Tratamento de exceção em kotlin", 2)
    val conteudo2 = ConteudoEducacional("Dominando kotlin", 2)
    
    val formacao1 = Formacao("analise e desenvolvimento de sistemas", listOf(conteudo1), Nivel.AVANCADO)
    val formacao2 = Formacao(nome = "kotlin iniciante", conteudos = listOf(conteudo1, conteudo2), nivel = Nivel.INTERMEDIARIO)
    formacao1.matricular(usuario1)
    formacao2.matricular(usuario2)
    
    println("inscritos na formação de ${formacao1.nome}")
    for (usuario in formacao1.inscritos){
        println("NOME:  ${usuario.nome}")
        println("CPF:  ${usuario.cpf}")
        println("Nivel: ${formacao1.nivel}")
    }
    println("inscritos na formação de ${formacao2.nome}")
    for (usuario in formacao2.inscritos){
        println("NOME:  ${usuario.nome}")
        println("CPF:  ${usuario.cpf}")
        println("Nivel: ${formacao2.nivel}")
    }    
}