package com.genio.service;

import com.genio.dto.input.ConventionServiceDTO;
import com.genio.dto.output.ConventionBinaireRes;
import com.genio.exception.business.GenerationConventionException;
import com.genio.exception.business.InvalidDataException;
import com.genio.exception.business.ModelNotFoundException;
import com.genio.exception.technical.FileConversionException;
import com.genio.exception.technical.SystemErrorException;
import com.genio.model.Convention;

import java.util.Map;

public interface GenioService {

    /**
     * Génère une convention à partir des données d'entrée.
     *
     * @param input Les données d'entrée sous forme de DTO.
     * @param formatFichierOutput Le format souhaité (PDF, DOCX).
     * @return Le résultat contenant le fichier binaire ou un code de réponse.
     * @throws IllegalArgumentException Si les données d'entrée sont invalides.
     * @throws ModelNotFoundException Si le modèle est introuvable.
     * @throws InvalidDataException Si les données de l'utilisateur sont invalides.
     * @throws GenerationConventionException Si la génération du document échoue.
     * @throws FileConversionException Si la conversion du fichier échoue.
     * @throws SystemErrorException Si une erreur système survient pendant le traitement.
     */
    ConventionBinaireRes generateConvention(ConventionServiceDTO input, String formatFichierOutput)
            throws IllegalArgumentException, ModelNotFoundException, InvalidDataException,
            GenerationConventionException, FileConversionException, SystemErrorException;

    Map<String, String> validerDonnees(ConventionServiceDTO input);
    boolean modeleExiste(Long modeleId);
    void sauvegarderHistorisation(ConventionServiceDTO input, Convention convention, byte[] fichierBinaire, String status, Map<String, String> erreurs);
}