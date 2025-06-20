import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        
        Curso curso1 = new Curso();
        curso1.setTitulo("Curso de Java");
        curso1.setDescricao("Descrição curso java");
        curso1.setCargaHoraria(8);

        Curso curso2 = new Curso();
        curso2.setTitulo("Curso de Js");
        curso2.setDescricao("Descrição curso js");
        curso2.setCargaHoraria(4);

        Mentoria mentoria = new Mentoria();
        mentoria.setTitulo("Mentoria de Java");
        mentoria.setDescricao("Descrição mentoria java");
        mentoria.setData(LocalDate.now());

        Bootcamp bootcamp = new Bootcamp();
        bootcamp.setNome("Bootcamp Java Developer");
        bootcamp.setDescricao("Descrição Bootcamp Java Developer");
        bootcamp.getConteudos().add(curso1);
        bootcamp.getConteudos().add(curso2);
        bootcamp.getConteudos().add(mentoria);

        Dev devRafael = new Dev();
        devRafael.setNome("Rafael");
        devRafael.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Rafael: " + devRafael.getConteudosInscritos());
        System.out.println(" ");
        devRafael.progredir();
        devRafael.progredir();
        System.out.println("Conteúdos Concluídos Rafael: " + devRafael.getConteudosConcluidos());
        System.out.println(" ");
        System.out.println("XP: " + devRafael.calcularTotalXP());

        System.out.println(" ");
        System.out.println(" -------------------------------- ");
        System.out.println(" ");

        Dev devMarcelo = new Dev();
        devMarcelo.setNome("Marcelo");
        devMarcelo.inscreverBootcamp(bootcamp);
        System.out.println("Conteúdos Inscritos Marcelo: " + devMarcelo.getConteudosInscritos());
        System.out.println(" ");
        devMarcelo.progredir();
        System.out.println("Conteúdos Concluídos Marcelo: " + devMarcelo.getConteudosConcluidos());
        System.out.println(" ");
        System.out.println("XP: " + devMarcelo.calcularTotalXP());
    }
    
}
