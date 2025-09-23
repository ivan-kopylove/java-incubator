package dasdas;

import java.time.LocalDate;
import java.time.Period;

public class CheckIssueDateJava
{
    private LocalDate now;

    public CheckIssueDateJava(LocalDate now)
    {
        this.now = now;
    }

    /**
     * Паспорт выдается по достижении 14 лет
     * Паспорт меняется в 20 и 45 лет
     * При достижении возраста замены, старый паспорт остается валидным 90 дней
     */
    public boolean isValid(LocalDate birthDate, LocalDate passportIssueDate)
    {
        int current = now.getYear() - birthDate.getYear();

        Period between = Period.between(birthDate, now);
        int fullYears = between.getYears();

        LocalDate a14 = birthDate.plusYears(14);
        LocalDate a20 = birthDate.plusYears(20);
        LocalDate a45 = birthDate.plusYears(45);


        if (fullYears < 14)
        {
            return false;
        }
        else if (fullYears >= 14 && fullYears <= 20)
        {
            LocalDate endOfGracePeriod = a20.plusDays(90);

            return endOfGracePeriod.isAfter(now) || endOfGracePeriod.equals(now) ;
        }
        else if (fullYears >= 20 && fullYears <= 45)
        {

        }
        else
        {
            return true;
        }



        return false;
    }
}