using System.Text.Json;

namespace Question1
{
    internal class Program
    {
        public static List<Teacher> list = new List<Teacher>();
        static void Main(string[] args)
        {
            Teacher teacher1 = new Teacher(1, "John", "B.Tech", "2020-10-10");
            Teacher teacher2 = new Teacher(2, "Prafull", "MSC", "2021-10-10");
            Teacher teacher3 = new Teacher(4, "Vikram", "M.Tech", "2000-10-10");
            Teacher teacher4 = new Teacher(1, "Pankaj", "B.Tech", "2023-10-10");

            list.Add(teacher1);
            list.Add(teacher2);
            list.Add(teacher3);
            list.Add(teacher4);

            WriteIntoTheFile(list);
            ReadFromTheFile();
        }
        public static void WriteIntoTheFile(List<Teacher> list)
        {
           string js = JsonSerializer.Serialize(list);
            File.WriteAllText("C:\\Users\\asus\\OneDrive\\Desktop\\Code\\Teachers.txt", js);
        }
        public static void ReadFromTheFile()
        {
            string js = File.ReadAllText("C:\\Users\\asus\\OneDrive\\Desktop\\Code\\Teachers.txt");
            List<Teacher> list = JsonSerializer.Deserialize<List<Teacher>>(js);

            foreach (var item in list)
            {
                Console.WriteLine(item.ToString());
            }
        }
    }
    public class Teacher {
        public int Id { get; set; }
        public string Name { get; set; }
        public string Qualification { get; set; }
        public string DateOfJoining { get; set; }

        public Teacher(int Id, string Name, string Qualification, string DateOfJoining)
        {
            this.Id = Id;
            this.Name = Name;
            this.Qualification = Qualification;
            this.DateOfJoining = DateOfJoining;
        }

        public override string ToString()
        {
            return "[Id=" + this.Id + ", Name=" + this.Name + ", Qualification=" + this.Qualification + ", DateOfJoining=" + this.DateOfJoining + "]";
        }
    }

}
