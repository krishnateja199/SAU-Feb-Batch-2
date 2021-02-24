
class SolveOneThread extends Thread{
    String string;
    SolveOneThread(String s){
        this.string=s;
    }
    public void run()
    {
        int count=0;

        char ch[]= new char[string.length()];
        for(int i=0;i<string.length();i++)
        {
            ch[i]= string.charAt(i);
            if( ((i>0)&&(ch[i]!=' ')&&(ch[i-1]==' ')) || ((ch[0]!=' ')&&(i==0)) )
                count++;
        }
        System.out.println("Number of words in the given string:"+count);
    }
}


public class OneThread {
    public static void main(String args[]) throws Exception{

        String s="Accolite is an innovative, design thinking software company that guarantees " +
                "seamless digital experiences with maximum results. Backed by the best technical minds in the industry, and only the best cutting edge technology, we strive to help our clients" +
                " overcome their digital challenges and achieve their goals.There is just building a solution to get the job done and then there is building the solution that is scalable, reliable and efficient. Our teams are trained to understand that difference and that shows up in " +
                "everything we do whether it is custom application development or technology consulting.Being a medium sized company and by retaining start-up culture, we are uniquely positioned to craft custom solutions to our customer needs and act with speed. " +
                "Our ability to service from several locations and our model of operating with low overheads makes us nimbler." +
                "We are not known in the industry for mass hiring. Instead, every recruit of ours is carefully screened and tested. What this means to our customers is working with some of the best and brightest" +
                " without having to reinvent the whole recruiting lifecycle for hiring the best talent.Customers never hear ‘It’s not my job’ from any of our associates and all of our teams strive to be outstanding customer service advocates in the field. This is one aspect that" +
                " has brought in referrals again and again from our customers. Please take a look at some of our testimonials.The Company aids in organizing classroom sessions seamlessly as well as proctored remote tests with AI/ML integration for preventing people from cheating both for local and global students.\n" +
                "Colleges and Universities can improve their student admissions and enrolments through the platform’s campus recruitment, training and extended placement solutions giving students a chance to participate in hiring drives and meeting their dream companies.\n" +
                "Students can extensively prepare for various competitive exams such as MBA, NDA, IAS, SSC, RRB, Bank PO by tapping into the in-depth question bank across any subject on the platform.\n" +
                "For Corporates:The technology provides learning and development solutions for corporates. They can fast process employee assessments, hiring and training, cut employee screening costs by almost half and reduce time to hire or train employees by enabling assessments from any location.\n" +
                "For Job Seekers: The Company’s technology helps job seekers identify which companies are currently hiring as well as also help them in strengthening their individual weak areas. Corporates and institutes such as Acer (for their Back to School Programme), AAIMS, Accolite, Evernote, Kuliza amongst others have chosen EduThrill as their technology partner of choice. There are more than 4,50,000 active end users in India of this cutting edge world class technology.\n" +
                "To sum up, the technology seamlessly takes off the pressure, whether on students or professionals and helps them get better in time management. EduThrill aims to touch hundreds of millions of lives by the year 2022, not only in India but on a global level.";
        SolveOneThread obj=new SolveOneThread(s);
        obj.start();

    }
}
