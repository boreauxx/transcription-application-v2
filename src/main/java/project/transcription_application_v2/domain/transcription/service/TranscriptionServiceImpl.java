package project.transcription_application_v2.domain.transcription.service;

import com.assemblyai.api.resources.transcripts.types.Transcript;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import project.transcription_application_v2.domain.paragraph.entity.Paragraph;
import project.transcription_application_v2.domain.transcription.entity.Transcription;
import project.transcription_application_v2.domain.transcription.repository.TranscriptionRepository;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TranscriptionServiceImpl implements TranscriptionService {

  private final TranscriptionRepository transcriptionRepository;

  public Transcription create(String name, List<Paragraph> paragraphs, Transcript transcript) {
    long size = 0L;
    if(transcript.getText().isPresent()) {
      size = transcript.getText().get().length();
    }
    Transcription transcription =  new Transcription(
        name,
        size,
        LocalDateTime.now(),
        LocalDateTime.now(),
        paragraphs
        ,null
    );
    paragraphs.forEach(paragraph -> {paragraph.setTranscription(transcription);});
    return transcription;
  }
}
