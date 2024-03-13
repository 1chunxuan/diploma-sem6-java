/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package control;

import da.ProgrammeDa;
import domain.Programme;

public class MaintainProgrammeControl {

    private ProgrammeDa progDA;

    public MaintainProgrammeControl() {
        progDA = new ProgrammeDa();
    }

    public Programme selectRecord(String code) {
        return progDA.getRecord(code);
    }

}
