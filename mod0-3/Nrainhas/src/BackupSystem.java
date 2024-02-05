import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BackupSystem {


    public interface Batch{
        int[] getFilesSize();
        int getTapeSize();
    }

    private static class NewBatch implements Batch{
        @Override
        public int[] getFilesSize() {
            return new int[] {70,10,20,40,60,50,50,100,100};
        }

        @Override
        public int getTapeSize() {
            return 100;
        }
    }

    private class Tape{
        private int stored;
        private int numberOfFiles;

        public Tape(int stored){
            this.stored=stored;
            this.numberOfFiles=1;

        }

        public void addStorage(int storage){
            this.stored += storage;
        }
        public void addFiles(){
            this.numberOfFiles++;
        }

        public int getStored() {
            return stored;
        }

        public void setStored(int stored) {
            this.stored = stored;
        }

        public int getNumberOfFiles() {
            return numberOfFiles;
        }

        public void setNumberOfFiles(int numberOfFiles) {
            this.numberOfFiles = numberOfFiles;
        }
    }

    public int getMinimumTapeCount(final Batch batch){

        int[] sizes= batch.getFilesSize();
        Arrays.sort(sizes);
        int tapes=0;

        List<Tape> list = new ArrayList<>();

        for (int i = sizes.length - 1; i >= 0; i--) {
            boolean stored = false;

            for (Tape tape : list) {
                if (i < sizes.length && ((tape.getStored() + sizes[i]) <= batch.getTapeSize()) && (tape.getNumberOfFiles() < 2)) {
                    tape.addStorage(sizes[i]);
                    tape.addFiles();
                    stored = true;
                    break;
                }
            }

            if (!stored && i < sizes.length) {
                tapes++;
                list.add(new Tape(sizes[i]));
            }
        }


        return tapes;
    }

    public static void main(String[] args) {
        BackupSystem backupSystem = new BackupSystem();
        Batch batch = new NewBatch();

        System.out.println(backupSystem.getMinimumTapeCount(batch));
    }
}
